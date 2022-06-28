package de.htwberlin.service;
import de.htwberlin.web.persistence.CreditorEntity;
import de.htwberlin.web.persistence.DebtsEntity;
import de.htwberlin.web.service.CreditorTransformer;
import de.htwberlin.web.service.DebtTransformer;
import de.htwberlin.web.persistence.Gender;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.Mockito.doReturn;


public class CreditorTransformerTest implements WithAssertions {

    private final CreditorTransformer underTest = new CreditorTransformer();

    @Test
    @DisplayName("should transform CreditorEntity to Creditor")
    void should_transform_CreditorEntity_to_Creditor() {
        var creditorEntity = Mockito.mock(CreditorEntity.class);
        doReturn(1L).when(creditorEntity).getId();
        doReturn("John").when(creditorEntity).getFirstName();
        doReturn("ABC").when(creditorEntity).getLastName();
        doReturn("Test").when(creditorEntity).getIdentifier();
        doReturn(Gender.MALE).when(creditorEntity).getGender();
        doReturn(List.of(new DebtsEntity())).when(creditorEntity).getDebtor();

        var result = underTest.transformEntity(creditorEntity);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getFirstName()).isEqualTo("John");
        assertThat(result.getLastName()).isEqualTo("ABC");
        assertThat(result.getIdentifier()).isEqualTo("Test");
        assertThat(result.getGender()).isEqualTo("MALE");
        assertThat(result.getDebtors()).hasSize(1);

    }
}
