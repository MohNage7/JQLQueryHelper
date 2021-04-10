package mohnage7;

import java.util.List;

public class JQLQuery {

    public String generateContainsQueryFrom(List<String> fileNamesList) {
        StringBuilder query = new StringBuilder();
        query.append("(");
        for (int i = 0; i < fileNamesList.size(); i++) {
            String queryBody = "summary ~ " + "\"" + fileNamesList.get(i) + "\"" + " ";
            query.append(queryBody);
            if (i != fileNamesList.size() - 1) {
                query.append(" OR ");
            }
        }
        query.append(")");
        return query.toString();
    }
}
