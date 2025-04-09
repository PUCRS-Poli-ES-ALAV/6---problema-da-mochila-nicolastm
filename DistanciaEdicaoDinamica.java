public class DistanciaEdicaoDinamica {

    public static int distanciaEdicaoPD(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] matriz = new int[m + 1][n + 1];
        int iteracoes = 0;

        for (int i = 0; i <= m; i++) {
            matriz[i][0] = i;
            iteracoes++;
        }
        for (int j = 0; j <= n; j++) {
            matriz[0][j] = j;
            iteracoes++;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                iteracoes++;
                int custo = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                matriz[i][j] = Math.min(
                        matriz[i - 1][j] + 1,
                        Math.min(
                                matriz[i][j - 1] + 1,
                                matriz[i - 1][j - 1] + custo
                        )
                );
            }
        }

        System.out.println("Iterações: " + iteracoes);
        return matriz[m][n];
    }

    public static void main(String[] args) {
        String s1a = "Casablanca";
        String s2a = "Portentoso";
        int distancia1 = distanciaEdicaoPD(s1a, s2a);
        System.out.println("Distância de Edição (PD): " + distancia1);

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

        int distancia2 = distanciaEdicaoPD(s1b, s2b);
        System.out.println("Distância de Edição (PD - texto grande): " + distancia2);
    }
}
