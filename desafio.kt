enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun exibirConteudos() {
        println("Conteúdos da formação $nome:")
        conteudos.forEachIndexed { index, conteudo ->
            println("${index + 1}. ${conteudo.nome} - ${conteudo.duracao} minutos")
        }
    }
}

fun main() {
    val usuario1 = Usuario("John Doe")
    val usuario2 = Usuario("Jane Smith")
    val usuario3 = Usuario("Alice Johnson")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)
    val conteudo3 = ConteudoEducacional("Testes Unitários", 60)

    val formacao = Formacao("Formação em Kotlin", listOf(conteudo1, conteudo2, conteudo3))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    formacao.exibirConteudos()
}
