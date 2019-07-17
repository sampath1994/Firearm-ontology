package application;

public class Gun {
	    private String gunName;
	    private double weight;
	    private int range;
	    private int fireRate;
	    private int price;

	    public Gun() {
	    	
	    }
	    public Gun(String gunName, double weight, int range, int fireRate, int price) {
			super();
			this.gunName = gunName;
			this.weight = weight;
			this.range = range;
			this.fireRate = fireRate;
			this.price = price;
		}

		public String getGunName() {
	        return gunName;
	    }

	    public void setGunName(String gunname) {
	        this.gunName = gunname;
	    }

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public int getRange() {
			return range;
		}

		public void setRange(int range) {
			this.range = range;
		}

		public int getFireRate() {
			return fireRate;
		}

		public void setFireRate(int fireRate) {
			this.fireRate = fireRate;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

    
}
