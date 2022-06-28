package de.htwberlin.web;

import de.htwberlin.web.service.CreditorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreditorRestController.class)
public class CreditorRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditorService creditorService;

    @Test
    @DisplayName("should return 404 if Creditor is not found")
    void should_return_404_if_creditor_is_not_found() throws Exception {
        // given
        doReturn(null).when(creditorService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/persons/123"))
                // then
                .andExpect(status().isNotFound());
    }

}
