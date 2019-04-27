package core.communication.container;


import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Container for rest communication. @Data to automatically transform it into json
 * @param <T>
 */
@Data
public class Container<T> {

    List<T> content;

    public Container(){
        content = new ArrayList<>();
    }

    public Container(T... tabOfT){
        this(Arrays.asList(tabOfT));
    }

    public Container(List<T> multipleElement){
        content = new ArrayList<>(multipleElement);
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
