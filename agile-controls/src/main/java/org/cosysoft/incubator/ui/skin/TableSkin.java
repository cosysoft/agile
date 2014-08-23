package org.cosysoft.incubator.ui.skin;

import org.cosysoft.incubator.ui.MoveShape;
import org.cosysoft.incubator.ui.DragContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.SkinBase;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Administrator
 */
public class TableSkin extends SkinBase<Control> {

    private Control c;
//    private MoveShape tCenter;
    private MoveShape tRight;
//    private MoveShape rCenter;
    private MoveShape rBottom;
//    private MoveShape bCenter;
    private MoveShape bLeft;
//    private MoveShape lCenter;
    private MoveShape lTop;

    private final List<MoveShape> moves = new ArrayList<>();
    private final Dimension2D move2D = new Dimension2D(10, 10);

    public TableSkin(Control c) {
        super(c);
        this.c = c;

        initDraggable();
        initResizeable();
        initResizeableHandler();

        init();
    }

    private void init() {
//        c.selectedProperty.addListener(new InvalidationListener() {
//            @Override
//            public void invalidated(Observable o) {
//                if (c.selectedProperty.get()) {
//                    getChildren().addAll(moves);
//                } else {
//                    getChildren().removeAll(moves);
//                }
//            }
//        });
    }

    @Override
    protected void layoutChildren(final double contentX, final double contentY,
            final double contentWidth, final double contentHeight) {

        for (int i = 0, max = getChildren().size(); i < max; i++) {
            Node child = getChildren().get(i);
            layoutInArea(child, contentX, contentY, contentWidth, contentHeight,
                    -1, Insets.EMPTY, false, false, HPos.LEFT, VPos.TOP);
        }
        positionInArea(lTop, -move2D.getWidth() / 2, -move2D.getHeight() / 2,
                contentWidth, contentHeight, -1, Insets.EMPTY, HPos.LEFT, VPos.TOP);
        positionInArea(tRight, c.getWidth() - move2D.getWidth() / 2, -move2D.getHeight() / 2,
                contentWidth, contentHeight, -1, Insets.EMPTY, HPos.LEFT, VPos.TOP);
        positionInArea(rBottom, c.getWidth() - move2D.getWidth() / 2, c.getHeight() - move2D.getHeight() / 2,
                contentWidth, contentHeight, -1, Insets.EMPTY, HPos.LEFT, VPos.TOP);
        positionInArea(bLeft, -move2D.getWidth() / 2, c.getHeight() - move2D.getHeight() / 2,
                contentWidth, contentHeight, -1, Insets.EMPTY, HPos.LEFT, VPos.TOP);
    }

    @Override
    public void dispose() {
        c = null;
    }

    private void initResizeable() {

        tRight = new MoveShape();
        rBottom = new MoveShape();
        bLeft = new MoveShape();
        lTop = new MoveShape();

        tRight.setCursor(Cursor.NE_RESIZE);
        rBottom.setCursor(Cursor.SE_RESIZE);
        bLeft.setCursor(Cursor.SW_RESIZE);
        lTop.setCursor(Cursor.NW_RESIZE);

        Collections.addAll(moves, tRight, rBottom, bLeft, lTop);

        for (MoveShape moveShape : moves) {
            moveShape.setPrefSize(move2D.getWidth(), move2D.getHeight());
        }
        this.getChildren().addAll(moves);
    }

    private void initResizeableHandler() {
        final BooleanProperty rBottomPressed = new SimpleBooleanProperty(false);
        final DragContext rBottomCtx = new DragContext();

        rBottom.setOnMousePressed((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                
                rBottomPressed.set(true);
                rBottomCtx.mouseAnchorX = t.getScreenX();
                rBottomCtx.mouseAnchorY = t.getScreenY();
                rBottomCtx.widthAnchor = c.getPrefWidth();
                rBottomCtx.heightAnchor = c.getPrefHeight();

                t.consume();
            }
        }));

        rBottom.setOnMouseDragged((MouseEvent t) -> {
            if (rBottomPressed.get()) {
                rBottomCtx.xDelta = t.getScreenX() - rBottomCtx.mouseAnchorX;
                rBottomCtx.yDelta = t.getScreenY() - rBottomCtx.mouseAnchorY;
                
                double newWidth = rBottomCtx.widthAnchor + rBottomCtx.xDelta;
                if (newWidth > 0) {
                    c.setPrefWidth(newWidth);
                    
                }
                double newHeight = rBottomCtx.heightAnchor + rBottomCtx.yDelta;
                if (newHeight > 0) {
                    c.setPrefHeight(newHeight);
                }
            }
            t.consume();
        });

        rBottom.setOnMouseReleased((MouseEvent t) -> {
            rBottomPressed.set(false);
            t.consume();
        });

        bLeft.setOnMousePressed((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                rBottomPressed.set(true);
                rBottomCtx.mouseAnchorX = t.getSceneX();
                rBottomCtx.mouseAnchorY = t.getSceneY();
                rBottomCtx.widthAnchor = c.getPrefWidth();
                rBottomCtx.heightAnchor = c.getPrefHeight();

                rBottomCtx.layoutX = c.getLayoutX();
                t.consume();
            }
        }));

        bLeft.setOnMouseDragged((MouseEvent t) -> {
            if (rBottomPressed.get()) {
                rBottomCtx.xDelta = t.getSceneX()- rBottomCtx.mouseAnchorX;
                rBottomCtx.yDelta =  t.getSceneY() - rBottomCtx.mouseAnchorY;
                
                double newWidth = rBottomCtx.widthAnchor + rBottomCtx.xDelta;
                if (newWidth > 0) {
                    c.setPrefWidth(rBottomCtx.widthAnchor - rBottomCtx.xDelta);
                    c.setLayoutX(rBottomCtx.layoutX + rBottomCtx.xDelta);
                    
                }
                double newHeight = rBottomCtx.heightAnchor + rBottomCtx.yDelta;
                if (newHeight > 0) {
                    c.setPrefHeight(rBottomCtx.heightAnchor + rBottomCtx.yDelta);
                }
            }
            t.consume();
        });

        bLeft.setOnMouseReleased((MouseEvent t) -> {
            rBottomPressed.set(false);
            t.consume();
        });

        lTop.setOnMousePressed((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                rBottomPressed.set(true);
                rBottomCtx.mouseAnchorX = t.getScreenX();
                rBottomCtx.mouseAnchorY = t.getScreenY();
                rBottomCtx.widthAnchor = c.getPrefWidth();
                rBottomCtx.heightAnchor = c.getPrefHeight();

                rBottomCtx.layoutX = c.getLayoutX();
                rBottomCtx.layoutY = c.getLayoutY();
                t.consume();
            }
        }));

        lTop.setOnMouseDragged((MouseEvent t) -> {
            if (rBottomPressed.get()) {
                rBottomCtx.xDelta = t.getScreenX() - rBottomCtx.mouseAnchorX;
                rBottomCtx.yDelta = t.getScreenY() - rBottomCtx.mouseAnchorY;
                
                double newWidth = rBottomCtx.widthAnchor + rBottomCtx.xDelta;
                if (newWidth > 0) {
                    c.setPrefWidth(rBottomCtx.widthAnchor - rBottomCtx.xDelta);
                    c.setLayoutX(rBottomCtx.layoutX + rBottomCtx.xDelta);
                }
                double newHeight = rBottomCtx.heightAnchor + rBottomCtx.yDelta;
                if (newHeight > 0) {
                    c.setPrefHeight(rBottomCtx.heightAnchor - rBottomCtx.yDelta);
                    c.setLayoutY(rBottomCtx.layoutY + rBottomCtx.yDelta);
                }
            }
            t.consume();
        });

        lTop.setOnMouseReleased((MouseEvent t) -> {
            rBottomPressed.set(false);
            t.consume();
        });

        tRight.setOnMousePressed((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                rBottomPressed.set(true);
                rBottomCtx.mouseAnchorX = t.getScreenX();
                rBottomCtx.mouseAnchorY = t.getScreenY();
                rBottomCtx.widthAnchor = c.getPrefWidth();
                rBottomCtx.heightAnchor = c.getPrefHeight();

                rBottomCtx.layoutX = c.getLayoutX();
                rBottomCtx.layoutY = c.getLayoutY();
                t.consume();
            }
        }));

        tRight.setOnMouseDragged((MouseEvent t) -> {
            if (rBottomPressed.get()) {
                rBottomCtx.xDelta = t.getScreenX() - rBottomCtx.mouseAnchorX;
                rBottomCtx.yDelta = t.getScreenY() - rBottomCtx.mouseAnchorY;
                
                double newWidth = rBottomCtx.widthAnchor + rBottomCtx.xDelta;
                if (newWidth > 0) {
                    c.setPrefWidth(rBottomCtx.widthAnchor + rBottomCtx.xDelta);
//                        c.setLayoutX(rBottomCtx.layoutX + rBottomCtx.xDelta);
                }
                double newHeight = rBottomCtx.heightAnchor + rBottomCtx.yDelta;
                if (newHeight > 0) {
                    c.setPrefHeight(rBottomCtx.heightAnchor - rBottomCtx.yDelta);
                    c.setLayoutY(rBottomCtx.layoutY + rBottomCtx.yDelta);
                }
            }
            t.consume();
        });

        tRight.setOnMouseReleased((MouseEvent t) -> {
            rBottomPressed.set(false);
            t.consume();
        });
    }

    private void initDraggable() {
        final DragContext dragContext = new DragContext();
        final BooleanProperty mousePressed = new SimpleBooleanProperty(false);
        
        
        c.setOnMousePressed((MouseEvent t) -> {
            mousePressed.set(true);
            c.setCursor(Cursor.MOVE);
            dragContext.mouseAnchorX = t.getX();
            dragContext.mouseAnchorY = t.getY();
            t.consume();
        });
        c.setOnMouseDragged((MouseEvent t) -> {
            if (mousePressed.get()) {
                dragContext.xDelta = t.getX() - dragContext.mouseAnchorX;
                dragContext.yDelta = t.getY() - dragContext.mouseAnchorY;

                c.relocate(c.getLayoutX() + dragContext.xDelta,
                        c.getLayoutY() + dragContext.yDelta);
            }
            t.consume();
        });
        c.setOnMouseReleased((MouseEvent t) -> {
            c.setCursor(Cursor.DEFAULT);
            mousePressed.set(false);
            t.consume();
        });
      
    }
    
    
}
