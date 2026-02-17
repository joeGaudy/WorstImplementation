
public class Employee
{
		String name;
		int hours;
		int money;
		String type;
		Employee[] e_array;
		
		
		public Employee(String name, int money, int hours, String type)
		{
			this.name = name;
			this.money = money;
			this.hours = hours;
			this.type = type;
		}
		
		public void setHours(int hours)
		{
			this.hours = hours;
		}
		
		
}
