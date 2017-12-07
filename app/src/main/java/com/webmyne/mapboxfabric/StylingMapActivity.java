package com.webmyne.mapboxfabric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StylingMapActivity extends AppCompatActivity {
    private Button btnMapStudioStyle;
    private Button btnLanguageSwitch;
    private Button btnLocalStyleSource;
    private Button btnDefaultStyle;
    private Button btnShowHideLayers;
    private Button btnColorSwitcher;
    private Button btnMapOption;
    private Button btnAdjustLayerOpacity;
    private Button btnGeojsonLayerInStack;
    private Button btnVectorSource;
    private Button btnAddWmsSource;
    private Button btnGeoJsonClustering;
    private Button btnSymbolLayer;
    private Button btnAnimateMapCamera;
    private Button btnBoundingBoxCamera;
    private Button btnCustomInfoWindow;
    private Button btnAnimatedMarker;
    private Button btnDrawCustomMarker;
    private Button btnDrawGeojsonLine;
    private Button btnDrawPolygon;
    private Button btnPopulationDensityExtrusion;
    private Button btnMarathonExtrusion;
    private Button btnAdjustExtrusionLight;
    private Button btnStyleCirclesCategorically;
    private Button btnChoroplethZoomChange;
    private Button btnZoomDependentFillColor;
    private Button btnSimpleOfflineMap;
    private Button btnOfflineManager;
    private Button btnSelectBuilding;
    private Button btnFeatureCount;
    private Button btnQueryFeature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styling_map);

        init();
        actionListener();
    }

    private void init() {
        btnMapStudioStyle = (Button) findViewById(R.id.btnMapStudioStyle);
        btnMapOption = (Button) findViewById(R.id.btnMapOption);
        btnLanguageSwitch = (Button) findViewById(R.id.btnLanguageSwitch);
        btnLocalStyleSource = (Button) findViewById(R.id.btnLocalStyleSource);
        btnDefaultStyle = (Button) findViewById(R.id.btnDefaultStyle);
        btnShowHideLayers = (Button) findViewById(R.id.btnShowHideLayers);
        btnColorSwitcher = (Button) findViewById(R.id.btnColorSwitcher);
        btnAdjustLayerOpacity = (Button) findViewById(R.id.btnAdjustLayerOpacity);
        btnGeojsonLayerInStack = (Button) findViewById(R.id.btnGeojsonLayerInStack);
        btnVectorSource = (Button) findViewById(R.id.btnVectorSource);
        btnAddWmsSource = (Button) findViewById(R.id.btnAddWmsSource);
        btnGeoJsonClustering = (Button) findViewById(R.id.btnGeoJsonClustering);
        btnSymbolLayer = (Button) findViewById(R.id.btnSymbolLayer);
        btnAnimateMapCamera = (Button) findViewById(R.id.btnAnimateMapCamera);
        btnBoundingBoxCamera = (Button) findViewById(R.id.btnBoundingBoxCamera);
        btnCustomInfoWindow = (Button) findViewById(R.id.btnCustomInfoWindow);
        btnAnimatedMarker = (Button) findViewById(R.id.btnAnimatedMarker);
        btnDrawCustomMarker = (Button) findViewById(R.id.btnDrawCustomMarker);
        btnDrawGeojsonLine = (Button) findViewById(R.id.btnDrawGeojsonLine);
        btnDrawPolygon = (Button) findViewById(R.id.btnDrawPolygon);
        btnPopulationDensityExtrusion = (Button) findViewById(R.id.btnPopulationDensityExtrusion);
        btnMarathonExtrusion = (Button) findViewById(R.id.btnMarathonExtrusion);
        btnAdjustExtrusionLight = (Button) findViewById(R.id.btnAdjustExtrusionLight);
        btnStyleCirclesCategorically = (Button) findViewById(R.id.btnStyleCirclesCategorically);
        btnChoroplethZoomChange = (Button) findViewById(R.id.btnChoroplethZoomChange);
        btnZoomDependentFillColor = (Button) findViewById(R.id.btnZoomDependentFillColor);
        btnSimpleOfflineMap = (Button) findViewById(R.id.btnSimpleOfflineMap);
        btnOfflineManager = (Button) findViewById(R.id.btnOfflineManager);
        btnSelectBuilding = (Button) findViewById(R.id.btnSelectBuilding);
        btnFeatureCount = (Button) findViewById(R.id.btnFeatureCount);
        btnQueryFeature = (Button) findViewById(R.id.btnQueryFeature);

    }

    private void actionListener() {
        btnMapOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMapOption = new Intent(StylingMapActivity.this, MapboxMapOptionActivity.class);
                startActivity(intentMapOption);
            }
        });

        btnMapStudioStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMapboxStudioStyle = new Intent(StylingMapActivity.this, MapboxStudioStyleActivity.class);
                startActivity(intentMapboxStudioStyle);
            }
        });

        btnLanguageSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLanguageSwitch = new Intent(StylingMapActivity.this, LanguageSwitchActivity.class);
                startActivity(intentLanguageSwitch);
            }
        });

        btnLocalStyleSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLocalStyleSource = new Intent(StylingMapActivity.this, LocalStyleSourceActivity.class);
                startActivity(intentLocalStyleSource);
            }
        });

        btnDefaultStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDefaultStyle = new Intent(StylingMapActivity.this, DefaultStyleActivity.class);
                startActivity(intentDefaultStyle);
            }
        });

        btnShowHideLayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShowHideLayers = new Intent(StylingMapActivity.this, ShowHideLayersActivity.class);
                startActivity(intentShowHideLayers);
            }
        });

        btnColorSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentColorSwitcher = new Intent(StylingMapActivity.this, ColorSwitcherActivity.class);
                startActivity(intentColorSwitcher);
            }
        });

        btnAdjustLayerOpacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdjustLayerOpacity = new Intent(StylingMapActivity.this, AdjustLayerOpacityActivity.class);
                startActivity(intentAdjustLayerOpacity);
            }
        });

        btnGeojsonLayerInStack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGeojsonLayerInStack = new Intent(StylingMapActivity.this, GeojsonLayerInStackActivity.class);
                startActivity(intentGeojsonLayerInStack);
            }
        });

        btnVectorSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVectorSource = new Intent(StylingMapActivity.this, VectorSourceActivity.class);
                startActivity(intentVectorSource);
            }
        });

        btnAddWmsSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddWmsSource = new Intent(StylingMapActivity.this, AddWmsSourceActivity.class);
                startActivity(intentAddWmsSource);
            }
        });

        btnGeoJsonClustering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGeoJsonClustering = new Intent(StylingMapActivity.this, GeoJsonClusteringActivity.class);
                startActivity(intentGeoJsonClustering);
            }
        });

        btnSymbolLayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSymbolLayer = new Intent(StylingMapActivity.this, SymbolLayerActivity.class);
                startActivity(intentSymbolLayer);
            }
        });

        btnAnimateMapCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAnimateMapCamera = new Intent(StylingMapActivity.this, AnimateMapCameraActivity.class);
                startActivity(intentAnimateMapCamera);
            }
        });

        btnBoundingBoxCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBoundingBoxCamera = new Intent(StylingMapActivity.this, BoundingBoxCameraActivity.class);
                startActivity(intentBoundingBoxCamera);
            }
        });

        btnCustomInfoWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCustomInfoWindow = new Intent(StylingMapActivity.this, CustomInfoWindowActivity.class);
                startActivity(intentCustomInfoWindow);
            }
        });

        btnAnimatedMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAnimatedMarker = new Intent(StylingMapActivity.this, AnimatedMarkerActivity.class);
                startActivity(intentAnimatedMarker);
            }
        });

        btnDrawCustomMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDrawCustomMarker = new Intent(StylingMapActivity.this, DrawCustomMarkerActivity.class);
                startActivity(intentDrawCustomMarker);
            }
        });

        btnDrawGeojsonLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDrawGeojsonLine = new Intent(StylingMapActivity.this, DrawGeojsonLineActivity.class);
                startActivity(intentDrawGeojsonLine);
            }
        });

        btnDrawPolygon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDrawPolygon = new Intent(StylingMapActivity.this, DrawPolygonActivity.class);
                startActivity(intentDrawPolygon);
            }
        });

        btnPopulationDensityExtrusion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDrawPolygon = new Intent(StylingMapActivity.this, PopulationDensityExtrusionActivity.class);
                startActivity(intentDrawPolygon);
            }
        });

        btnMarathonExtrusion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMarathonExtrusion = new Intent(StylingMapActivity.this, MarathonExtrusionActivity.class);
                startActivity(intentMarathonExtrusion);
            }
        });

        btnAdjustExtrusionLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMarathonExtrusion = new Intent(StylingMapActivity.this, AdjustExtrusionLightActivity.class);
                startActivity(intentMarathonExtrusion);
            }
        });

        btnStyleCirclesCategorically.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStyleCirclesCategorically = new Intent(StylingMapActivity.this, StyleCirclesCategoricallyActivity.class);
                startActivity(intentStyleCirclesCategorically);
            }
        });

        btnChoroplethZoomChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStyleCirclesCategorically = new Intent(StylingMapActivity.this, ChoroplethZoomChangeActivity.class);
                startActivity(intentStyleCirclesCategorically);
            }
        });

        btnZoomDependentFillColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStyleCirclesCategorically = new Intent(StylingMapActivity.this, ZoomDependentFillColorActivity.class);
                startActivity(intentStyleCirclesCategorically);
            }
        });

        btnSimpleOfflineMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStyleCirclesCategorically = new Intent(StylingMapActivity.this, SimpleOfflineMapActivity.class);
                startActivity(intentStyleCirclesCategorically);
            }
        });

        btnOfflineManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStyleCirclesCategorically = new Intent(StylingMapActivity.this, OfflineManagerActivity.class);
                startActivity(intentStyleCirclesCategorically);
            }
        });

        btnSelectBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStyleCirclesCategorically = new Intent(StylingMapActivity.this, SelectBuildingActivity.class);
                startActivity(intentStyleCirclesCategorically);
            }
        });

        btnFeatureCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStyleCirclesCategorically = new Intent(StylingMapActivity.this, FeatureCountActivity.class);
                startActivity(intentStyleCirclesCategorically);
            }
        });

        btnQueryFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStyleCirclesCategorically = new Intent(StylingMapActivity.this, QueryFeatureActivity.class);
                startActivity(intentStyleCirclesCategorically);
            }
        });


    }
}
