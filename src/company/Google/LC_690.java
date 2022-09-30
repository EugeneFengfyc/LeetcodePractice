package company.Google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public static void main(String[] args) {
        LC_690 test = new LC_690();
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put (e.id, e);
        }
        return dfs(map, id);
    }

    public int dfs(Map<Integer, Employee> map, int id) {
        Employee temp = map.get(id);
        int res = temp.importance;
        for (Integer i : temp.subordinates) {
            res += dfs(map, i);
        }
        return res;
    }
}

