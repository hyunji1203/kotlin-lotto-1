import domain.Lotto
import domain.Lottos
import domain.RandomLottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {

    private val testLottos = listOf(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        Lotto(listOf(1, 2, 4, 6, 34, 45)), Lotto(listOf(3, 5, 15, 23, 33, 43)),
        Lotto(listOf(4, 6, 15, 18, 24, 35))
    )
    @Test
    fun `로또 리스트가 생성되는지 확인`() {
        val lottos = Lottos(testLottos)
        assertThat(lottos.lottos.size).isEqualTo(4)
    }

    @Test
    fun `금액에 맞게 로또 리스트가 생성되는지 확인`() {
        val lottos = RandomLottoGenerator().generateLottos(10000)
        assertThat(lottos.lottos.size).isEqualTo(10)
    }
}