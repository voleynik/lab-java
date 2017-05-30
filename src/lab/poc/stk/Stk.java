package lab.stk;

public class Stk {
	private String _s;
	public String get_s() {	return _s;}
	public void set_s(String _s) {this._s = _s;}
	private double _d = 999.99;
	public double get_d() {return _d;}
	public void set_d(double _d) {this._d = _d;}
	private double _p = -1;
	public double get_p() {return _p;}
	public void set_p(double _p) {this._p = _p;}
	public Stk (){}
	public Stk(String s, double p, double d){
		_s = s;
		_d = d;
		_p = p;
	}
	public String toString(Stk stk){
		if(stk == null){
			return null;
		}
		return stk.get_s() + " " + stk.get_p() + " " + stk.get_d();
	}
}
