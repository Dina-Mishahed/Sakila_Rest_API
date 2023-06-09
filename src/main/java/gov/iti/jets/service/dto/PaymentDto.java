package gov.iti.jets.service.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.entity.Payment} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class PaymentDto implements Serializable {
    private Short paymentId;
    private BigDecimal amount;
    private Date paymentDate;
    private Date lastUpdate;
}