package collection;

import java.util.Objects;

public class Gugudan {
	
	private int IValue;
	private int rValue;
	
	public Gugudan(int IValue, int rValue) {
		// TODO Auto-generated constructor stub
		this.IValue = IValue;
		this.rValue = rValue;
	}

	public int getIValue() {
		return IValue;
	}

	public void setIValue(int iValue) {
		IValue = iValue;
	}

	public int getrValue() {
		return rValue;
	}

	public void setrValue(int rValue) {
		this.rValue = rValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(IValue * rValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gugudan other = (Gugudan) obj;
		return IValue*rValue == other.IValue * other.rValue;
	}

	@Override
	public String toString() {
		return "Gugudan [IValue=" + IValue + ", rValue=" + rValue + "]";
	}
	
	
	
	
	
}
