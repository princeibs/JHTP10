package Chapter9;

// Fig. 9.6: BasePlusCommissionEmployee.java
//

public class BasePlusCommissionEmployee 
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private double grossSales;
    private double commissionRate;
    private double baseSalary;
    
    // six-argument constructor
    public BasePlusCommissionEmployee(String firstName, String lastName, 
            String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) 
    {
        // implicit call to Object's default comstructor occurs here
        
        // validate gross sales
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        
        // validate commissionRate
        if (commissionRate < 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        
        // validate base salary
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate  = commissionRate;
        this.baseSalary = baseSalary;
    }
        
    
    // Get and Set methods
    
    public String getFirstName()
    {
        return firstName;
    }
        
    public String getLastName()
    {
        return lastName;
    }
    
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }
    
    public void setGrossSales(double grossSales)
    {
      if (grossSales < 0.0)      
          throw new IllegalArgumentException("Gross sales must be >= 0.0");     
      
      this.grossSales = grossSales;
    }
    
    public double getGrossSales()
    {
        return grossSales;
    }
    
    public void setCommissionRate(double commissionRate)
    {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        
        this.commissionRate = commissionRate;
    }
    
    public double getCommissionRate()
    {
        return commissionRate;
    }
    
    public void setBaseSalary(double baseSalary) 
    {
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        
        this.baseSalary = baseSalary;
    }
    
    public double getBaseSalary()
    {
        return baseSalary;
    }
    
    public double earnings()
    {
        return baseSalary + (commissionRate * grossSales);
    }
    
    // return String representation of BasePlusCommissionEmployee
    @Override
    public String toString()
    {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f",
        "base-salaried commission employee", firstName, lastName, "social-security number",
        socialSecurityNumber, "gross sales", grossSales, "commission rate", commissionRate,
        "baseSalary", baseSalary);
    }    
}