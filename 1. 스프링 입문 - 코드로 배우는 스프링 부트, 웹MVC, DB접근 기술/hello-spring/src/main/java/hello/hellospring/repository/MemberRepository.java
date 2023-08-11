// package
package hello.hellospring.repository;
// Local
import hello.hellospring.domain.Member;
// Built-in
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long Id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
