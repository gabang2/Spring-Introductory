package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override // JPQL select m from Member m where m.name = ? <- interface이름만으로도 개발이 가능하다.
    Optional<Member> findByName(String name);
}
