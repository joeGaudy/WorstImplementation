import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class pay_tests
{

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@Test
    void hourlyUnder40() {
        Employee[] employees = {
            new Employee("A", 10, 30, "hourly") // $10/hr, 30 hrs
        };

        pay p = new pay();
        float[] result = p.payroll(employees);

        assertEquals(300.0f, result[0], 0.0001f);
    }

    @Test
    void hourlyExactly40() {
        Employee[] employees = {
            new Employee("B", 20, 40, "hourly") // $20/hr, 40 hrs
        };

        pay p = new pay();
        float[] result = p.payroll(employees);

        assertEquals(800.0f, result[0], 0.0001f);
    }

    @Test
    void hourlyOver40() {
        Employee[] employees = {
            new Employee("C", 10, 45, "hourly") // 40*10 + 5*(10*1.5) = 400 + 75 = 475
        };

        pay p = new pay();
        float[] result = p.payroll(employees);

        assertEquals(475.0f, result[0], 0.0001f);
    }

    @Test
    void salary_pay() {
        Employee[] employees = {
            new Employee("D", 50, 10, "salary") // code says money*40 => 50*40 = 2000
        };

        pay p = new pay();
        float[] result = p.payroll(employees);

        assertEquals(2000.0f, result[0], 0.0001f);
    }

    @Test
    void contractor_pay() {
        Employee[] employees = {
            new Employee("E", 15, 10, "contractor")
        };

        pay p = new pay();
        float[] result = p.payroll(employees);

        assertEquals(150.0f, result[0], 0.0001f);
    }

    @Test
    void multipleEmployees() {
        Employee[] employees = {
            new Employee("A", 10, 30, "hourly"),   // 300
            new Employee("B", 10, 45, "hourly"),   // 475
            new Employee("C", 50, 0, "salary"),    // 2000
            new Employee("D", 20, 5, "contract")   // 100
        };

        pay p = new pay();
        float[] result = p.payroll(employees);

        assertEquals(4, result.length);
        assertEquals(300.0f, result[0], 0.0001f);
        assertEquals(475.0f, result[1], 0.0001f);
        assertEquals(2000.0f, result[2], 0.0001f);
        assertEquals(100.0f, result[3], 0.0001f);
    }

}
