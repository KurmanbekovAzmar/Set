package sevise;

import models.Group;

import java.util.List;

public interface GroupService {
    void addGroup(Group group);
    void getGroupById(Long id);
    void updateGroupByName(String groupName);
    List<Group> getAllGroups();
    String deleteGroup(Long id);
}
