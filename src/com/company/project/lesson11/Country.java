package com.company.project.lesson11;

// enum могут реализовывать интерфейсы
// enum не могут расширять другие классы,
// так в enum уже реализовано наследование
public enum Country {
    // элементы перечисления - экземпляры типа Country
    FRANCE("France", 136656) {
        // public void franceVoid(){}
        @Override
        public void sout() {
            System.out.println("реализация FRANCE");
        }
    },
    USA("USA", 46356) {
        @Override
        public void sout() {
            System.out.println("реализация USA");
        }
    },
    ITALY("Italy", 76585) {
        @Override
        public void sout() {
            System.out.println("реализация ITALY");
        }
    }; // Country[FRANCE, USA, ITALY]

    private String name;
    private long population;

    /* private */ Country(String name, long population) {
        this.name = name;
        this.population = population;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    abstract public void sout();
}
