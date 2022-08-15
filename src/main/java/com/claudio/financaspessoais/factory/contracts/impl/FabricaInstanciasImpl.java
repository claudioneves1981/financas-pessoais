package com.claudio.financaspessoais.factory.contracts.impl;

import com.claudio.financaspessoais.db.contracts.LancamentosEntityRepository;
import com.claudio.financaspessoais.factory.contracts.FabricaInstancias;
import com.claudio.financaspessoais.services.contracts.LancamentosService;
import com.claudio.financaspessoais.services.contracts.impl.LancamentosServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

    @Component
    @AllArgsConstructor(onConstructor = @__(@Autowired))
    public class FabricaInstanciasImpl implements FabricaInstancias {

        private LancamentosEntityRepository lancamentosEntityRepository;

        @Override
        public LancamentosService getLancamentosServiceImple() {
            return LancamentosServiceImpl.getInstance(this.lancamentosEntityRepository);
        }
}
