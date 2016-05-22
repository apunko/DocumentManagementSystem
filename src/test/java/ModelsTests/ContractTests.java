package ModelsTests;


import Models.Contract;
import Models.ContractTemplate;
import Models.PayForm;
import Models.User;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ContractTests {

    private Contract contract;
    private int id = 190;
    private Date payDate = new Date();
    private Date startDate = new Date();
    private Date endDate = new Date();
    private int paySum = 100;

    private int payFormId = 1;
    private int clientId = 1;
    private int templateId = 1;
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<Contract>> constraintViolations;

    @Before
    public void setUp() throws Exception {
        contract = new Contract();
    }

    @Test
    public void createContract() throws Exception {
        assertNotNull(contract);
    }

    @Test
    public void validateEmptyContract() throws Exception {
        constraintViolations = validator.validate(contract);
        assertEquals(constraintViolations.size() > 0, true);
    }

    @Test
    public void setPayDate() throws Exception {
        contract.setPayDate(payDate);
        assertEquals(contract.getPayDate(), payDate);
    }

    @Test
    public void setStartDate() throws Exception {
        contract.setStartDate(startDate);
        assertEquals(contract.getStartDate(), startDate);
    }

    @Test
    public void setEndDate() throws Exception {
        contract.setEndDate(endDate);
        assertEquals(contract.getEndDate(), endDate);
    }

    @Test
    public void setPaySum() throws Exception {
        contract.setPaySum(paySum);
        assertEquals(contract.getPaySum(), paySum);
    }

    @Test
    public void setTemplate() throws Exception {
        contract.setTemplate(new ContractTemplate());
        assertNotNull(contract.getTemplate());
    }

    @Test
    public void setPayForm() throws Exception {
        contract.setPayForm(new PayForm());
        assertNotNull(contract.getPayForm());
    }

    @Test
    public void setUser() throws Exception {
        contract.setClient(new User());
        assertNotNull(contract.getClient());
    }

    @Test
    public void validContract() throws Exception {
        contract.setPayDate(payDate);
        contract.setStartDate(startDate);
        contract.setEndDate(endDate);
        contract.setPaySum(paySum);
        contract.setTemplate(new ContractTemplate());
        contract.setPayForm(new PayForm());
        contract.setClient(new User());
        constraintViolations = validator.validate(contract);
        assertEquals(constraintViolations.size() == 0, true);
    }
}
