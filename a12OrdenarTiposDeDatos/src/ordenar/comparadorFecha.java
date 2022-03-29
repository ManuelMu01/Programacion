package ordenar;

import java.util.Comparator;

public class comparadorFecha implements Comparator<Vehiculo>  {

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {

		if (o1.fecha.compareTo(o2.fecha)==0) return 0;
		
		if (o1.fecha.compareTo(o2.fecha)==1) return 1;
		
		return -1;
	}

}
