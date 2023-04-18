package hostelManagement.view.TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTM {

    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;
}
