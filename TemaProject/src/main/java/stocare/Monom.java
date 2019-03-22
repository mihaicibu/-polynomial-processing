package stocare;


public class Monom implements Comparable<Monom> {
	private double coeficient;
	private int exponent;
	
	public Monom(double coeficient, int exponent) {
		this.coeficient = coeficient;
		this.exponent = exponent;
	}

	public double getCoeficient() {
		return  coeficient;
	}

	public void setCoeficient(double coeficient) {
		this.coeficient = coeficient;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}
	
	public Monom imparteMonoame(Monom m) {
		Monom rezultat = new Monom(this.getCoeficient() / m.getCoeficient(), this.getExponent() - m.getExponent());
		return rezultat;
	}
	
	public String toString() {
		if (this.getCoeficient() > 0)
			if(this.getExponent() == 1)
				if(this.getCoeficient() == 1)
					return "+x";
				else return "+" + String.format("%.2f", this.getCoeficient()) + "x";
			else if(this.getExponent() == 0)
					if(this.getCoeficient() == 1)
						return "+1";
					else return "+" + String.format("%.2f", this.getCoeficient());
				else if(this.getCoeficient() == 1)
						return "+x^" + this.getExponent();
				else return "+" + String.format("%.2f", this.getCoeficient()) + "x^" + this.getExponent();
		else if (this.getCoeficient() < 0)
			if(this.getExponent() == 1)
				if(this.getCoeficient() == -1)
					return "-x";
				else return  String.format("%.2f", this.getCoeficient()) + "x";
			else if(this.getExponent() == 0)
					if(this.getCoeficient() == -1)
						return "-1";
					else return String.format("%.2f", this.getCoeficient()) + "";
				else if(this.getCoeficient() == -1)
						return "-x^" + this.getExponent();
				else return String.format("%.2f", this.getCoeficient()) + "x^" + this.getExponent();
		
		return "";
	}

	public int compareTo(Monom monom) {
		if( this.getExponent() - monom.getExponent() < 0) return 1;
		else if(this.getExponent() - monom.getExponent() > 0) return -1;
		return 0;
	}

}
