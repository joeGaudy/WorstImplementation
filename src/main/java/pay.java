
public class pay
{
	public float[] payroll(Employee[] employees) {
		float[] pay_array = new float[employees.length];
		
		for (int i=0; i < employees.length; i++) {
			if (employees[i].type == "hourly")
			{
				if (employees[i].hours <= 40)
				{
					pay_array[i] = employees[i].hours * employees[i].money;
				} else 
				{
					pay_array[i] = (float) ((employees[i].money * 40) + (employees[i].hours - 40)*(employees[i].money*1.5));
				}
			}
			else if (employees[i].type == "salary")
			{
				pay_array[i] = employees[i].money * 40;
			} else
			{
				pay_array[i] = employees[i].money * employees[i].hours;
			}
		}
		
		return pay_array;
	}

}
