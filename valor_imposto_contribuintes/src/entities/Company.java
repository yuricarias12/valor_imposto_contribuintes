package entities;

public class Company extends TaxPayer {

    private Integer quantity_employees;


    public Company() {
        super();
    }

    public Company(String name, Double anualIncome, Integer quantity_employees) {
        super(name, anualIncome);
        this.quantity_employees = quantity_employees;
    }

    public Integer getQuantity_employees() {
        return quantity_employees;
    }

    public void setQuantity_employees(Integer quantity_employees) {
        this.quantity_employees = quantity_employees;
    }
    @Override
    public Double tax() {

        if (quantity_employees > 10) {

            return getAnualIncome() * 0.14;

        } else {

            return getAnualIncome() * 0.16;
        }

    }
}
