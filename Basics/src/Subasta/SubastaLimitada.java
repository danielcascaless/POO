package Subasta;

public class SubastaLimitada extends  Subasta{
	private int maximoPujas;
	public SubastaLimitada(String nombreProducto, String propietario,int maximoPujas) {
		super(nombreProducto,propietario);
		this.maximoPujas = maximoPujas;	
		}
	public int getMaximoPujas() {
		return maximoPujas;
	}
	public void setMaximoPujas(int maximoPujas) {
		this.maximoPujas = maximoPujas;
	}
	@Override
	public Boolean pujar(String pujador, double cantidad) {
		if(lista.size() >= this.maximoPujas) return false;
		else return super.pujar(pujador,cantidad);
	}
	
}
