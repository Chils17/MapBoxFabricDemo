package custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import com.mapbox.services.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.services.commons.models.Position;
import com.webmyne.mapboxfabric.R;

import adapter.GeocoderAdapter;


/**
 * Created by chiragpatel on 17-10-2017.
 */

public class GeocoderAutoCompleteView extends android.support.v7.widget.AppCompatAutoCompleteTextView {
    private static final int DEFAULT_NUMBER_OF_LINES = 1;

    private GeocoderAdapter adapter;
    private Drawable imgClearButton;

    public interface OnFeatureListener {
        void onFeatureClick(CarmenFeature feature);
    }

    private OnFeatureListener onFeatureListener = null;

    public GeocoderAutoCompleteView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Get attributes from attrs.xml
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.mas_geocoderWidget);
        imgClearButton = attributes.getDrawable(R.styleable.mas_geocoderWidget_mas_clearButtonDrawable);
        attributes.recycle();

        // Set custom adapter
        adapter = new GeocoderAdapter(context);
        setAdapter(adapter);

        // Set number of lines
        setLines(DEFAULT_NUMBER_OF_LINES);

        // Set click listener
        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CarmenFeature result = adapter.getItem(position);
                setText(result.toString());

                // Notify subscribers
                if (onFeatureListener != null) {
                    onFeatureListener.onFeatureClick(result);
                }
            }
        });

        // Add clear button to autocomplete
        if (imgClearButton == null) {
            imgClearButton = ContextCompat.getDrawable(context, R.drawable.ic_clear_black_24dp);
        }
        setCompoundDrawablesWithIntrinsicBounds(null, null, imgClearButton, null);
        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                GeocoderAutoCompleteView et = (GeocoderAutoCompleteView) view;
                if (et.getCompoundDrawables()[2] == null) {
                    return false;
                }
                if (event.getAction() != MotionEvent.ACTION_UP) {
                    return false;
                }
                if (event.getX() > et.getWidth() - et.getPaddingRight() - imgClearButton.getIntrinsicWidth()) {
                    setText("");
                }
                return false;
            }
        });
    }

    /**
     * Can be used to cancel any calls currently in progress. It's a good idea to include in onDestroy() to prevent
     * memory leaks
     *
     * @since 2.0.0
     */
    public void cancelApiCall() {
        adapter.cancelApiCall();
    }

  /*
   * Setters
   */

    /**
     * Set the base url of the API.
     *
     * @param baseUrl base url used as end point
     * @since 2.0.0
     */
    public void setBaseUrl(String baseUrl) {
        adapter.setBaseUrl(baseUrl);
    }

    /**
     * You'll need to have a Mapbox access token to use the geocoding API within MAS.
     *
     * @param accessToken Your Mapbox access token
     * @see <a href="https://www.mapbox.com/help/define-access-token/">Mapbox access token</a>
     * @since 1.0.0
     */
    public void setAccessToken(String accessToken) {
        adapter.setAccessToken(accessToken);
    }

    /**
     * Configure the geocoder type, pass in one of the constants found within
     * {@link com.mapbox.services.api.geocoding.v5.GeocodingCriteria}.
     *
     * @param type String containing "place", "poi", "neighborhood", etc.
     * @see <a href="https://www.mapbox.com/api-documentation/#request-format">Geocoding API documentation</a>
     * @since 1.0.0
     */
    public void setType(String type) {
        adapter.setType(type);
    }

    /**
     * Configure the geocoder type, pass in one or more of the constants found within
     * {@link com.mapbox.services.api.geocoding.v5.GeocodingCriteria}.
     *
     * @param types String array containing "place", "poi", "neighborhood", etc.
     * @see <a href="https://www.mapbox.com/api-documentation/#request-format">Geocoding API documentation</a>
     * @since 2.0.0
     */
    public void setTypes(String[] types) {
        adapter.setTypes(types);
    }

    /**
     * Parameter limits results to a country. Use one of the
     * <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166 alpha 2</a> country codes.
     *
     * @param country String matching country code.
     * @since 2.0.0
     */
    public void setCountry(String country) {
        adapter.setCountry(country);
    }

    /**
     * Parameter limits results to a set of one or more countries. Use one or more of the
     * <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166 alpha 2</a> country codes,
     * separated by commas inside a String array.
     *
     * @param countries String array containing the country codes you want to limit results to.
     * @since 2.0.0
     */
    public void setCountries(String[] countries) {
        adapter.setCountries(countries);
    }

    /**
     * Bounding box within which to limit results.
     *
     * @param northeast The top right hand corner of your bounding box when the map is pointed north.
     * @param southwest The bottom left hand corner of your bounding box when the map is pointed north.
     * @since 1.3.0
     */
    public void setBbox(Position northeast, Position southwest) {
        adapter.setBbox(southwest.getLongitude(), southwest.getLatitude(),
                northeast.getLongitude(), northeast.getLatitude());
    }

    /**
     * Bounding box within which to limit results.
     *
     * @param minX Bottom of bounding box when map is pointed north.
     * @param minY Left of bounding box when map is pointed north.
     * @param maxX Top of bounding box when map is pointed north.
     * @param maxY Right of bounding box when map is pointed north.
     * @since 1.3.0
     */
    public void setBbox(double minX, double minY, double maxX, double maxY) {
        adapter.setBbox(minX, minY, maxX, maxY);
    }

    /**
     * Location around which to bias geocoder results.
     *
     * @param position {@link Position} coordinate.
     * @see <a href="https://www.mapbox.com/api-documentation/#request-format">Geocoding API documentation</a>
     * @since 1.0.0
     */
    public void setProximity(Position position) {
        adapter.setProximity(position);
    }

    /**
     * Limit the number of results returned. The default is 5.
     *
     * @param limit the integer value representing the amount of results desired.
     * @since 2.0.0
     */
    public void setLimit(int limit) {
        adapter.setLimit(limit);
    }

    /**
     * The locale in which results should be returned.
     * <p>
     * This property affects the language of returned results; generally speaking,
     * it does not determine which results are found. If the Geocoding API does not
     * recognize the language code, it may fall back to another language or the default
     * language. Components other than the language code, such as the country and
     * script codes, are ignored.
     * <p>
     * By default, this property is set to `null`, causing results to be in the default
     * language.
     * <p>
     * This option is experimental.
     *
     * @param language The locale in which results should be returned.
     * @since 2.0.0
     * @deprecated use {@link GeocoderAutoCompleteView#setLanguages(String...)} instead
     */
    @Deprecated
    public void setLanguage(String language) {
        adapter.setLanguage(language);
    }

    /**
     * The locale in which results should be returned.
     * <p>
     * This property affects the language of returned results; generally speaking,
     * it does not determine which results are found. If the Geocoding API does not
     * recognize the language code, it may fall back to another language or the default
     * language. Components other than the language code, such as the country and
     * script codes, are ignored.
     * <p>
     * By default, this property is set to `null`, causing results to be in the default
     * language.
     * <p>
     * This option is experimental.
     *
     * @param languages The locale in which results should be returned.
     * @since 2.0.0
     */
    public void setLanguages(String... languages) {
        adapter.setLanguage(languages);
    }

    /**
     * Sets the listener that will be notified when the user clicks an item in the drop down list.
     *
     * @param onFeatureListener the item click listener.
     * @since 1.0.0
     */
    public void setOnFeatureListener(OnFeatureListener onFeatureListener) {
        this.onFeatureListener = onFeatureListener;
    }
}
