package byhasmap;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnotherMapEntryConverter implements Converter {

    @Override
    public boolean canConvert(Class clazz) {
        return Map.class.isAssignableFrom(clazz);
    }

    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        Map map = (Map) value;
        for (Object obj : map.entrySet()) {
            Map.Entry entry = (Map.Entry) obj;
            writer.startNode(entry.getKey().toString());
            Object val = entry.getValue();
            if (val != null) context.convertAnother(val);
            writer.endNode();
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        while (reader.hasMoreChildren()) {
            reader.moveDown();

            String key = reader.getNodeName();
            Object value = null;

            if (reader.hasMoreChildren()) {
                value = unmarshal(reader, context);
            } else {
                value = reader.getValue();
            }

            map.put(key, value);
            reader.moveUp();
        }

        return map;
    }
}
