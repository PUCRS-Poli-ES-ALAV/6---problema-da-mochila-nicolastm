public class DistanciaEdicaoRec {

    static int iteracoes = 0;

    public static int distanciaEdicaoRec(String s1, String s2, int m, int n) {
        iteracoes++;
        if (m == 0) return n;
        if (n == 0) return m;

        int custo = (s1.charAt(m - 1) == s2.charAt(n - 1)) ? 0 : 1;

        return Math.min(
                distanciaEdicaoRec(s1, s2, m - 1, n) + 1,
                Math.min(
                        distanciaEdicaoRec(s1, s2, m, n - 1) + 1,
                        distanciaEdicaoRec(s1, s2, m - 1, n - 1) + custo
                )
        );
    }

    public static void main(String[] args) {
        String s1a = "Casablanca";
        String s2a = "Portentoso";
        int distancia1 = distanciaEdicaoRec(s1a, s2a, s1a.length(), s2a.length());
        System.out.println("Distância de Edição (Rec): " + distancia1);
        System.out.println("Iterações: " + iteracoes);

        iteracoes = 0; // resetar contador antes do segundo teste

        String s1b = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
                "simplify the build processes in the Jakarta Turbine project. There were several" +
                " projects, each with their own Ant build files, that were all slightly different." +
                "JARs were checked into CVS. We wanted a standard way to build the projects, a clear " +
                "definition of what the project consisted of, an easy way to publish project information" +
                "and a way to share JARs across several projects. The result is a tool that can now be" +
                "used for building and managing any Java-based project. We hope that we have created " +
                "something that will make the day-to-day work of Java developers easier and generally help " +
                "with the comprehension of any Java-based project.";
        String s2b = "This post is not about deep learning. But it could be might as well. This is the power of " +
                "kernels. They are universally applicable in any machine learning algorithm. Why you might" +
                "ask? I am going to try to answer this question in this article." +
                "Go to the profile of Marin Vlastelica Pogančić" +
                "Marin Vlastelica Pogančić Jun";

        int distancia2 = distanciaEdicaoRec(s1b, s2b, s1b.length(), s2b.length());
        System.out.println("Distância de Edição (Rec - texto grande): " + distancia2);
        System.out.println("Iterações: " + iteracoes);
    }
}
