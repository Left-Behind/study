package work.azhu.common.test_dependent_package;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Son implements Serializable {

    private Integer age;

    private Integer high;

    private Integer weight;

}
