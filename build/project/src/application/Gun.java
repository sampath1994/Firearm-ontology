package application;

public class Gun {
	    private String gunName;
	    private String weight;
	    private String range;
	    private String fireRate;
	    private String price;

	    public Gun() {
	    	
	    }
	    public Gun(String gunName, String weight, String range, String fireRate, String price) {
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

		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}

		public String getRange() {
			return range;
		}

		public void setRange(String range) {
			this.range = range;
		}

		public String getFireRate() {
			return fireRate;
		}

		public void setFireRate(String fireRate) {
			this.fireRate = fireRate;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

    
}
