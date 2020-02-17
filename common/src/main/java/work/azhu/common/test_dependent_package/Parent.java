package work.azhu.common.test_dependent_package;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class Parent implements Serializable {

    private Integer age;

    private Integer high;

    private Integer weight;

    private Son son;

    private List<Son> sons;
}
