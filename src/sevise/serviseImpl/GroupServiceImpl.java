package sevise.serviseImpl;

import dataBase.DataBase;
import dataBase.GenerateId;
import models.Group;
import sevise.GroupService;

import java.util.List;
import java.util.Scanner;

public class GroupServiceImpl implements GroupService {
    @Override
    public void addGroup(Group group) {
        DataBase.groups.add(group);
    }

    @Override
    public void getGroupById(Long id) {
        for(Group group:DataBase.groups){
            if(group.getId()==id){
                System.out.println(group);
                break;
            }
        }
    }

    @Override
    public void updateGroupByName(String groupName) {
        Scanner scanner = new Scanner((System.in));
        for(Group group:DataBase.groups){
            if(group.getGroupName().equalsIgnoreCase(groupName)){
                System.out.println("Write new name: ");
                group.setGroupName(scanner.nextLine());
                System.out.println("Write new description: ");
                group.setDescription(scanner.nextLine());
                System.out.println("Sucesfuly");
                break;
            }else {
                System.out.println("There is no such group");
                break;
            }
        }
    }

    @Override
    public List<Group> getAllGroups() {
        return DataBase.groups;
    }

    @Override
    public String deleteGroup(Long id) {
        for(Group group : DataBase.groups){
            if(group.getId()==id){
                DataBase.groups.remove(group);
                return "Succesfully!!!!";
            }
        }
    return "invalid";
    }
}
