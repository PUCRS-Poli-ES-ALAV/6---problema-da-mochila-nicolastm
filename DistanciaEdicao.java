public class DistanciaEdicao {

    public static int distEdProgDina(String A, String B) {
        int m = A.length();
        int n = B.length();
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
                int custoExtra = (A.charAt(i - 1) == B.charAt(j - 1)) ? 0 : 1; 
                matriz[i][j] = Math.min(
                        Math.min(matriz[i - 1][j] + 1, 
                                matriz[i][j - 1] + 1), 
                        matriz[i - 1][j - 1] + custoExtra 
                );
                iteracoes++;
            }
        }

        System.out.println("Número de iterações: " + iteracoes);
        return matriz[m][n];
    }

    public static void main(String[] args) {
        
        String s1 = "Casablanca";
        String s2 = "Portentoso";

        int distancia = distEdProgDina(s1, s2);
        System.out.println("Distância de edição entre '" + s1 + "' e '" + s2 + "': " + distancia);

        String longS1 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
                "simplify the build processes in the Jakarta Turbine project. There were several " +
                "projects, each with their own Ant build files, that were all slightly different. " +
                "JARs were checked into CVS. We wanted a standard way to build the projects, a clear " +
                "definition of what the project consisted of, an easy way to publish project information " +
                "and a way to share JARs across several projects. The result is a tool that can now be " +
                "used for building and managing any Java-based project. We hope that we have created " +
                "something that will make the day-to-day work of Java developers easier and generally help " +
                "with the comprehension of any Java-based project.";
        String longS2 = "This post is not about deep learning. But it could be might as well. This is the power of " +
                "kernels. They are universally applicable in any machine learning algorithm. Why you might " +
                "ask? I am going to try to answer this question in this article. " +
                "Go to the profile of Marin Vlastelica Pogančić " +
                "Marin Vlastelica Pogančić Jun";

        distancia = distEdProgDina(longS1, longS2);
        System.out.println("Distância de edição entre os textos longos: " + distancia);
    }
}