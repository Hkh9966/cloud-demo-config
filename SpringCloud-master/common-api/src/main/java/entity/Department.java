package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Long depNo;
    private String depName;
    /**
     * 来自哪个库
     */
    private String dbSource;
}
