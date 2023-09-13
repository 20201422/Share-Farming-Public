package JavaBean;

import Model.User;

public class ChangeInfoBean extends BaseDao {

    /**
     * 修改用户信息
     * @param user
     */
    public void updateInfo(User user) {
        update("update Users set Una=?,Upwd=?,Uemil=? where Uno=?", user.getUna(), user.getUpwd(), user.getUemil(), user.getUno());
    }


}
