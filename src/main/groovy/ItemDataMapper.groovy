import org.nomin.Mapping

import static Itemtype.INVALID_TYPE

class ItemDataMapper extends Mapping {

    protected void build() {
        mappingFor a: ItemData, b: CombinedItem

        a.datafield = b.data

        a.type = { ->
            if (b.type == INVALID_TYPE) {
                return null
            }
            return b.type.toString()
        }
        b.type = { ->
            return a.type ? Itemtype.valueOf(a.type) : INVALID_TYPE
        }
        // The following code works in Groovy 2.5
        //b.type = { ->
        //    return a.data.type ? Itemtype.valueOf(a.data.type) : INVALID_TYPE
        //}
    }

}
