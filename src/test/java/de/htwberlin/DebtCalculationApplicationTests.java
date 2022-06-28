package de.htwberlin;

import de.htwberlin.web.api.Creditor;
import de.htwberlin.web.api.Debts;
import de.htwberlin.web.persistence.DebtsEntity;
import de.htwberlin.web.service.DebtService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class DebtCalculationApplicationTests {

	@Test
	@DisplayName("Test1")
	void contextLoads() {
	}

	// create, get all als Test, negative Zahlen, 1 Debts gehört zu diesem Victim überprüfen

}
