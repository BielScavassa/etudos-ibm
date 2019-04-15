package firstproject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AlunoInterfaceImpl implements AlunoInterface {

	@Override
	public int age(LocalDate dataNascimento) {
		LocalDate now = LocalDate.now();
		long age = ChronoUnit.YEARS.between(dataNascimento, now);
				
		return (int) age;
	}
	
}
