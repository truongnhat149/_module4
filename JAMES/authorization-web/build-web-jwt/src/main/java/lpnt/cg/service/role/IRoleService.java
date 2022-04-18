package lpnt.cg.service.role;

import lpnt.cg.model.Role;
import lpnt.cg.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
