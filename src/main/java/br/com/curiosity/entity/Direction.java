package br.com.curiosity.entity;

public enum Direction {

    N(0,1) {
        @Override
        public Direction left() {
            return W;
        }

        @Override
        public Direction right() {
            return E;
        }
    },

    S(0,-1) {
        @Override
        public Direction right() {
            return W;
        }

        @Override
        public Direction left() {
            return E;
        }
    },

    E(1,0) {
        @Override
        public Direction right() {
            return S;
        }

        @Override
        public Direction left() {
            return N;
        }
    },

    W(-1,0) {
        @Override
        public Direction right() {
            return N;
        }

        @Override
        public Direction left() {
            return S;
        }
    };

    private int xMove;
    private int yMove;

    private Direction( int xMove,  int yMove) {
        this.xMove = xMove;
        this.yMove = yMove;
    }
    
    public abstract Direction right();
    public abstract Direction left();

    public int xMove() {
        return this.xMove;
    }

    public int yMove() {
        return this.yMove;
    }
}