import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
class PythagoreanTriplet {
	private int factorsLessThanOrEqualTo;
	private int sumOfThreeFactors;
	private int firstTerm;
	private int secondTerm;
	private int thirdTerm;
	
	public PythagoreanTriplet() {
		// empty
	}
	
	PythagoreanTriplet(int firstTerm, int secondTerm, int thirdTerm) {
		this.firstTerm = firstTerm;
		this.secondTerm = secondTerm;
		this.thirdTerm = thirdTerm;
	}
	static PythagoreanTriplet makeTripletsList() {
		return new PythagoreanTriplet();
	}
	PythagoreanTriplet withFactorsLessThanOrEqualTo(int i) {
		factorsLessThanOrEqualTo = i;
		return this;
	}
	PythagoreanTriplet thatSumTo(int i) {
		sumOfThreeFactors = i;
		return this;
	}
	List<PythagoreanTriplet> build() {
		List<PythagoreanTriplet> tripletList = new ArrayList<>();
		
		if (sumOfThreeFactors % 2 == 1) {
			return tripletList;
		}
		
		for (int a = 1; a < sumOfThreeFactors / 2; a++) {
			if ((a * sumOfThreeFactors) % (a - sumOfThreeFactors) == 0) {
	            int b = (sumOfThreeFactors * (2 * a - sumOfThreeFactors)) / (2 * a - 2 * sumOfThreeFactors);
	            int c = sumOfThreeFactors - a - b;
	            
	            if (a < b && c <= factorsLessThanOrEqualTo) { 
			    	tripletList.add(new PythagoreanTriplet(a, b, c));
	            }
			}
		}
		
		return tripletList;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstTerm, secondTerm, thirdTerm);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PythagoreanTriplet other = (PythagoreanTriplet) obj;
		
		return firstTerm == other.firstTerm && secondTerm == other.secondTerm && thirdTerm == other.thirdTerm;
	}
	@Override
	public String toString() {
		return "PythagoreanTriplet [a=" + firstTerm + ", b=" + secondTerm + ", c=" + thirdTerm + "]";
	}
	
}