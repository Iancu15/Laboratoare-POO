package ex1;

class Car {
    class OttoEngine implements Engine {
        private int fuelCapacity;
 
        public OttoEngine(int fuelCapacity) {
            this.fuelCapacity = fuelCapacity;
        }
 
        public int getFuelCapacity() {
            return fuelCapacity;
        }
    }
 
    public OttoEngine getEngine() {
        OttoEngine engine = new OttoEngine(11);
        return engine;
    }
    
    public Engine getEngine(int fuelCapacity) {
        return new Engine () {
            private int fuelCapacity = 11;
 
            public int getFuelCapacity() {
                return fuelCapacity;
            }
        };
    }
}
