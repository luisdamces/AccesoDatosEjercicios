package ExamenEvaluacion2Ejercicio3;

import java.util.List;

public interface EquipoDao {
	
	public boolean create(Equipo equipo);
	public List<Equipo>read();
	public boolean update(Equipo equipo);
	public boolean delete(Equipo equipo);
	
}
