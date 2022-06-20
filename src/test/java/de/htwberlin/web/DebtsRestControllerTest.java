package de.htwberlin.web;

import de.htwberlin.web.api.Debts;
import de.htwberlin.web.service.CreditorService;
import de.htwberlin.web.service.DebtService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DebtsRestController.class)
public class DebtsRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DebtService debtService;

    @Test
    @DisplayName("should return 404 if debts is not found")
    void should_return_404_if_debts_is_not_found() throws Exception {
        // given
        doReturn(null).when(debtService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/persons/123"))
                // then
                .andExpect(status().isNotFound());
    }

}
