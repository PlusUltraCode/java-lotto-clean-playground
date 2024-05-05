package model;

import java.util.ArrayList;
import java.util.List;


public class Consumer {

    private final ConsumerMoney inputMoney;

    private List<Lotto> haveLottos = new ArrayList<>();

    public Consumer(final int money) {

        this.inputMoney = ConsumerMoney.from(money);
    }

    public void BuyLottos() {

        int lottoCount = inputMoney.value() / Lotto.getPrice();

        for (int i = 0; i < lottoCount; i++) {

            Lotto lotto = new Lotto(LottoMachine.makeAutoNumber());
            haveLottos.add(lotto);
        }
    }

    public void analizeAllLottos(List<Integer> collectNumber) {

        int collectedCount = 0;

        for (Lotto lotto : haveLottos) {
            collectedCount = analizeOneLotto(lotto, collectNumber);
            lotto.setCollectedCount(collectedCount);
        }
    }

    private int analizeOneLotto(Lotto lotto, List<Integer> collectNumber) {

        int collectedCount = 0;

        for (int i = 0; i < collectNumber.size(); i++) {
            if (lotto.getLottoNumber().contains(collectNumber.get(i))) collectedCount++;
        }

        return collectedCount;
    }

    public List<Lotto> getHaveLottos() {
        return haveLottos;
    }

    public int getMoney() {
        return inputMoney.value();
    }
}
