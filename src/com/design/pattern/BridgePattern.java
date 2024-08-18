package com.design.pattern;

public class BridgePattern {
    interface color {
        void paint();
    }

    class Red implements color {

        @Override
        public void paint() {
            System.out.println("Red Painting");
        }
    }

    class White implements color {

        @Override
        public void paint() {
            System.out.println("White Painting");
        }
    }

    abstract class Shape{
        protected color col;

        protected Shape(color col) {
            this.col = col;
        }

        abstract void draw();
    }

    class Circle extends Shape {
        public Circle(color col) {
            super(col);
        }

        @Override
        void draw() {
            col.paint();
        }
    }

}
