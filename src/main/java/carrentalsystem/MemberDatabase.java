package carrentalsystem;


import java.util.HashSet;

public class MemberDatabase {
    private static MemberDatabase memberDatabase;
    private HashSet<Member> setOfMembers;

    private MemberDatabase() {
        setOfMembers = new HashSet<>();
    }

    public static MemberDatabase getMemberDatabase() {
        if (memberDatabase == null) {
            synchronized (MemberDatabase.class) {
                if (memberDatabase == null) memberDatabase = new MemberDatabase();
            }
        }
        return memberDatabase;
    }

    public boolean addMember(Member member) {
        if (setOfMembers.contains(member)) return false;
        setOfMembers.add(member);
        return true;
    }

    public boolean removeMember(Member member) {
        return setOfMembers.remove(member);
    }
}

