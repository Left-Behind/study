package work.azhu.springbootnetty.attribute;

import io.netty.util.AttributeKey;
import work.azhu.springbootnetty.session.Session;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
