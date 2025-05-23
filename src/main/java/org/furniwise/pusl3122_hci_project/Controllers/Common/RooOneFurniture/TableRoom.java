package org.furniwise.pusl3122_hci_project.Controllers.Common.RooOneFurniture;
//
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.stage.Stage;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.TableNode;
//
//public class TableRoom extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    private double mouseX, mouseY;
//    private boolean isDragging = false;
//
//    private Group roomGroup;
//    private TableNode table;
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create a material for the walls and floor
//        PhongMaterial wallMaterial = new PhongMaterial();
//        wallMaterial.setDiffuseColor(Color.LIGHTGRAY);
//        PhongMaterial floorMaterial = new PhongMaterial();
//        floorMaterial.setDiffuseColor(Color.GRAY);
//
//        // Create the floor
//        Box floor = new Box(ROOM_WIDTH, 1, ROOM_DEPTH);
//        floor.setMaterial(floorMaterial);
//        floor.setTranslateY(ROOM_HEIGHT / 2 - 60);
//        floor.setTranslateZ(-ROOM_DEPTH / 2 + 300);
//        floor.setTranslateX(-ROOM_WIDTH / 2 + 300);
//        floor.setTranslateY(ROOM_HEIGHT / 2 - 150);
//
//        // Create walls
//        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);
//        wallBack.setMaterial(wallMaterial);
//        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
//        wallBack.setTranslateZ(+300);
//
//        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);
//        wallLeft.setMaterial(wallMaterial);
//        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
//        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);
//        wallRight.setMaterial(wallMaterial);
//        wallRight.setTranslateX(ROOM_WIDTH / 2);
//        wallRight.setTranslateY(-ROOM_HEIGHT / 2);
//
//        // Create a group to hold all parts of the room
//        roomGroup = new Group(floor, wallBack, wallLeft, wallRight);
//
//        // Center the room
//        roomGroup.setTranslateX((WIDTH - ROOM_WIDTH) / 2 - 200);
//        roomGroup.setTranslateY((HEIGHT - ROOM_HEIGHT) / 2 - 150);
//
//        // Create the table
//        table = new TableNode();
//        roomGroup.getChildren().add(table);
//
//        // Create a layout pane for 2D content overlay
//        StackPane overlayPane = new StackPane();
//        overlayPane.setPrefSize(WIDTH, HEIGHT);
//
//        // Create the scene with the roomGroup and overlayPane
//        Scene scene = new Scene(new Group(roomGroup, overlayPane), WIDTH, HEIGHT, true);
//        scene.setFill(Color.WHITE);
//
//        // Set up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setTranslateX(-150);
//        camera.setTranslateY(-150);
//        camera.setTranslateZ(-1000);
//        camera.setNearClip(0.1);
//        camera.setFarClip(10000.0);
//        scene.setCamera(camera);
//
//        // Set up mouse event handlers for table rotation
//        scene.setOnMousePressed(event -> {
//            table.setMouseStart(event.getSceneX(), event.getSceneY());
//        });
//
//        scene.setOnMouseDragged(event -> {
//            table.rotateTable(event.getSceneX(), event.getSceneY());
//        });
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.LEFT) {
//                table.rotateTableNode(0.0, -10.0, 0.0); // Rotate table left
//            } else if (event.getCode() == KeyCode.RIGHT) {
//                table.rotateTableNode(0.0, 10.0, 0.0); // Rotate table right
//            } else if (event.getCode() == KeyCode.UP) {
//                table.adjustTranslation(0, 0, -10); // Move table forward
//            } else if (event.getCode() == KeyCode.DOWN) {
//                table.adjustTranslation(0, 0, 10); // Move table backward
//            }
//        });
//
//        // Set up keyboard event handlers
////        scene.setOnKeyPressed(event -> {
////            if (event.getCode() == KeyCode.LEFT) {
////                table.rotateTableNode(0, -10, 0); // Rotate table left
////            } else if (event.getCode() == KeyCode.RIGHT) {
////                table.rotateTableNode(0, 10, 0); // Rotate table right
////            } else if (event.getCode() == KeyCode.UP) {
////                table.adjustTranslation(0, 0, -10); // Move table forward
////            } else if (event.getCode() == KeyCode.DOWN) {
////                table.adjustTranslation(0, 0, 10); // Move table backward
////            }
////        });
//
//        primaryStage.setTitle("JavaFX 3D Table Room");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.RoundTableNode;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.TableNode;

public class TableRoom extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double ROOM_WIDTH = 600;
    private static final double ROOM_HEIGHT = 300;
    private static final double ROOM_DEPTH = 600;

    private Group roomGroup;
    private TableNode table;

    private double mouseX, mouseY;
    private boolean isDragging = false;

    private static final double ZOOM_SPEED = 50;

    @Override
    public void start(Stage primaryStage) {
        // Create a material for the walls and floor
        PhongMaterial wallMaterial = new PhongMaterial();
        wallMaterial.setDiffuseColor(Color.LIGHTGRAY);
        PhongMaterial floorMaterial = new PhongMaterial();
        floorMaterial.setDiffuseColor(Color.GRAY);

        // Create the floor
        Box floor = new Box(ROOM_WIDTH, 1, ROOM_DEPTH);
        floor.setMaterial(floorMaterial);
        floor.setTranslateY(ROOM_HEIGHT / 2 - 60);
        floor.setTranslateZ(-ROOM_DEPTH / 2 + 300);
        floor.setTranslateX(-ROOM_WIDTH / 2 + 300);
        floor.setTranslateY(ROOM_HEIGHT / 2 - 150);

        // Create walls
        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);
        wallBack.setMaterial(wallMaterial);
        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
        wallBack.setTranslateZ(+300);

        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);
        wallLeft.setMaterial(wallMaterial);
        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);

        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);
        wallRight.setMaterial(wallMaterial);
        wallRight.setTranslateX(ROOM_WIDTH / 2);
        wallRight.setTranslateY(-ROOM_HEIGHT / 2);

        // Create a group to hold all parts of the room
        roomGroup = new Group(floor, wallBack, wallLeft, wallRight);

        // Center the room
        roomGroup.setTranslateX((WIDTH - ROOM_WIDTH) / 2 - 200);
        roomGroup.setTranslateY((HEIGHT - ROOM_HEIGHT) / 2 - 150);

        // Create the table
        table = new TableNode();
        table.setTranslateY(-100);
//        table.setTranslateY(100); // Adjust position of the table

//        table.adjustTranslation(-100);

        roomGroup.getChildren().add(table);

        // Create a layout pane for 2D content overlay
        StackPane overlayPane = new StackPane();
        overlayPane.setPrefSize(WIDTH, HEIGHT);

        // Create the scene with the roomGroup and overlayPane
        Scene scene = new Scene(new Group(roomGroup, overlayPane), WIDTH, HEIGHT, true);
        scene.setFill(Color.WHITE);

        // Set up the camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateX(-150);
        camera.setTranslateY(-150);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        scene.setCamera(camera);



        // Set up mouse event handlers for chair rotation
        scene.setOnMousePressed(event -> {
            table.setMouseStart(event.getSceneX(), event.getSceneY());
        });

        scene.setOnMouseDragged(event -> {
            table.rotateTable(event.getSceneX(), event.getSceneY());
        });


        scene.setOnMousePressed(event -> {
            mouseX = event.getSceneX();
            mouseY = event.getSceneY();
            isDragging = table.getBoundsInParent().contains(event.getX(), event.getY());
        });

        scene.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - mouseX;
            double deltaY = event.getSceneY() - mouseY;
            table.adjustTranslation(deltaX, deltaY, 0);
            mouseX = event.getSceneX();
            mouseY = event.getSceneY();
        });

        scene.setOnMouseReleased(event -> {
            isDragging = false;
        });

//        // Set up mouse event handlers for dragging and dropping
//        scene.setOnMousePressed(event -> {
//            mouseX = event.getSceneX();
//            mouseY = event.getSceneY();
//            isDragging = roundTable.getBoundsInParent().contains(event.getX(), event.getY());
//        });
//
//        scene.setOnMouseDragged(event -> {
//            if (isDragging) {
//                double deltaX = event.getSceneX() - mouseX;
//                double deltaY = event.getSceneY() - mouseY;
//                roundTable.adjustTranslation(deltaX, deltaY, 0);
//                mouseX = event.getSceneX();
//                mouseY = event.getSceneY();
//            }
//        });

//        scene.setOnMouseReleased(event -> {
//            isDragging = false;
//        });

//        // Set up keyboard event handlers for rotating the room
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.LEFT) {
//                roomGroup.setRotationAxis(javafx.geometry.Point3D.ZERO);
//                roomGroup.setRotate(roomGroup.getRotate() - 10); // Rotate room left
//            } else if (event.getCode() == KeyCode.RIGHT) {
//                roomGroup.setRotationAxis(javafx.geometry.Point3D.ZERO);
//                roomGroup.setRotate(roomGroup.getRotate() + 10); // Rotate room right
//            }
//        });

        // Set up keyboard event handlers
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                table.rotateTableNode(0, -10, 0); // Rotate chair left
            } else if (event.getCode() == KeyCode.RIGHT) {
                table.rotateTableNode(0, 10, 0); // Rotate chair right
            } else if (event.getCode() == KeyCode.A) {
//                roomGroup.setRotationAxis(javafx.geometry.Point3D.ZERO);
//                roomGroup.setRotate(roomGroup.getRotate() - 10); // Rotate room left
                roomGroup.setRotationAxis(Rotate.Y_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() + 10);
            } else if (event.getCode() == KeyCode.D) {
//                roomGroup.setRotationAxis(javafx.geometry.Point3D.ZERO);
//                roomGroup.setRotate(roomGroup.getRotate() + 10); // Rotate room right
                roomGroup.setRotationAxis(Rotate.Y_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() - 10);
            } else if (event.getCode() == KeyCode.W) {
//                roomGroup.setRotationAxis(javafx.geometry.Point3D.ZERO);
//                roomGroup.setRotate(roomGroup.getRotate() - 10); // Rotate room left
                roomGroup.setRotationAxis(Rotate.X_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() + 10);
            } else if (event.getCode() == KeyCode.S) {
//                roomGroup.setRotationAxis(javafx.geometry.Point3D.ZERO);
//                roomGroup.setRotate(roomGroup.getRotate() + 10); // Rotate room right
                roomGroup.setRotationAxis(Rotate.X_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() - 10);
            } else if (event.getCode() == KeyCode.UP) {
                table.adjustTranslation(0, 0, -10); // Move chair forward
            } else if (event.getCode() == KeyCode.DOWN) {
                table.adjustTranslation(0, 0, 10); // Move chair backward
            }else if (event.getCode() == KeyCode.G) {
                camera.setTranslateZ(camera.getTranslateZ() - ZOOM_SPEED); // Zoom in
            } else if (event.getCode() == KeyCode.T) {
                camera.setTranslateZ(camera.getTranslateZ() + ZOOM_SPEED); // Zoom out
            }

        });


        primaryStage.setTitle("JavaFX 3D Table Room");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
