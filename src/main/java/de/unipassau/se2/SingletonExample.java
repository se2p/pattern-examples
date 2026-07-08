package de.unipassau.se2;

public class SingletonExample {

    static class GameConfig {
        private static GameConfig instance;
        private int trapDamage = 2;

        private GameConfig() {
        }

        public static GameConfig getInstance() {
            if (instance == null) {
                instance = new GameConfig();
            }
            return instance;
        }

        public int getTrapDamage() {
            return trapDamage;
        }

        public void setTrapDamage(int trapDamage) {
            this.trapDamage = trapDamage;
        }
    }

    class Trap {
        public void trigger() {
            System.out.println("Trap damage: " + GameConfig.getInstance().getTrapDamage());
        }
    }

    public void demo() {
        new Trap().trigger();
        GameConfig.getInstance().setTrapDamage(5);
        new Trap().trigger();
    }

    public static void main(String[] args) {
        new SingletonExample().demo();
    }
}
